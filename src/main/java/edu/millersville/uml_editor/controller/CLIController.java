package edu.millersville.uml_editor.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.jline.reader.History;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.MaskingCallback;
import org.jline.reader.impl.DefaultParser;

import org.jline.reader.impl.completer.AggregateCompleter;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.reader.impl.history.DefaultHistory;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.view.*;
import edu.millersville.uml_editor.cli_command.*;
import edu.millersville.uml_editor.cli_command.TabCompleter;

public class CLIController extends ControllerType{

    private UMLModel model;
    private CLIView view;
    private boolean prompt;
    private Terminal terminal;
    private History history;
    private DefaultParser parser;
    private LineReader savePromptReader;
    private LineReader reader;
    private ArrayList<Memento> mementos;
    private String file;
    protected int currMeme;
    private Originator originator;
    private CareTaker careTaker;
	
    /**
     * A method that initializes the model, tab completer, and cli.
     * @param model
     * @param view
     * @throws IOException
     */
    public CLIController(UMLModel model, ViewTemplate view) throws IOException {
        super();
        this.model = model;
        this.view = (CLIView) view.getViewinterface();
        currMeme = 0;
        mementos = new ArrayList<Memento>();
        //mementos.add(new Memento(this.model));
        originator = new Originator();
        careTaker  = new CareTaker();
        terminal = TerminalBuilder.builder().system(true).build();
     
        AggregateCompleter completer = new TabCompleter().updateCompleter(model);

        StringsCompleter savePromptCompleter = new StringsCompleter("yes", "no");

        history = new DefaultHistory();

        parser = new DefaultParser();
        parser.setEscapeChars(new char[]{});

        reader = LineReaderBuilder.builder().terminal(terminal).completer(completer).history(history)
                .variable(LineReader.MENU_COMPLETE, true).parser(parser).build();

        savePromptReader = LineReaderBuilder.builder().terminal(terminal).completer(savePromptCompleter)
                .variable(LineReader.MENU_COMPLETE, true).parser(parser).build();
    }

    /**
     * A method that prints and handles what the user sees and does.
     */
    public void init() throws IOException {
        view.printIntro();

        while (true) {
            String line = null;

            line = reader.readLine("Enter a command: ", "", (MaskingCallback) null, null);
            line = line.trim();

            String[] commands = line.split(" ");
            
            evaluateCommand(commands);

            AggregateCompleter completer = new TabCompleter().updateCompleter(model);

            reader = LineReaderBuilder.builder().terminal(terminal).completer(completer).history(history)
                    .variable(LineReader.MENU_COMPLETE, true).parser(parser).build();
        }
    }

    /**
     * A method that executes the command based on the first word of the command.
     * @param commands a list of commands.
     */
    public void evaluateCommand(String[] commands) {
    	// creates a new memento of the current model.
        Memento meme = new Memento(new UMLModel(this.model.getClasses(), this.model.getRelationships()));
        originator.setState(meme.getModel());
        careTaker.add(originator.saveStateToMemento());
        // goes through the commands and executes.
        switch (commands[0]) {
            case "quit":
                MiscCommand quit = new MiscCommand(model, view, commands, prompt, savePromptReader);
                prompt = quit.execute();
                break;
            case "help":
                MiscCommand help = new MiscCommand(model, view, commands, prompt, savePromptReader);
                prompt = help.execute();
                break;
            case "save":
                SaveCommand save = new SaveCommand(model, view, commands, prompt, file);
                prompt = save.execute();
                file = save.getFile();
                break;
            case "load":
                LoadCommand load = new LoadCommand(meme.getModel(), view, commands, prompt, savePromptReader, file);
                prompt = load.execute();
                file = load.getFile();
                newMeme(meme);
                break;
            case "add":
                
            	AddCommand create = new AddCommand(meme.getModel(), view, commands, prompt);
                create.execute();
                
                newMeme(meme);
                break;
            case "delete":
                DeleteCommand delete = new DeleteCommand(meme.getModel(), view, commands, prompt);
                prompt = delete.execute();
                newMeme(meme);
                break;
            case "rename":
                RenameCommand rename = new RenameCommand(meme.getModel(), view, commands, prompt);
                prompt = rename.execute();
                newMeme(meme);
                break;
            case "list":
                ListCommand list = new ListCommand(model, view, commands, prompt);
                prompt = list.execute();
                break;
            case "clear":
                MiscCommand clear = new MiscCommand(meme.getModel(), view, commands, prompt, savePromptReader);
                prompt = clear.execute();
                newMeme(meme);
                break;
            case "undo":
            	if (currMeme > 0) {
                    --currMeme;
                    this.model = mementos.get(currMeme).getModel();
                    prompt = true;
                } else {
                    System.out.println("No actions to undo.");

                }
                break;
            case "redo":
            	 if (currMeme < mementos.size() - 1) {
                     ++currMeme;
                     this.model = mementos.get(currMeme).getModel();
                     prompt = true;
                 } else {
                     System.out.println("No actions to redo.");
                 }
                break;
            default:
                view.printInvalidCommand();
        }
    }
/*
    private void undo() {
        if (currMeme > 0) {
            --currMeme;
            this.model = mementos.get(currMeme).getModel();
            prompt = true;
        } else {
            System.out.println("No actions to undo.");

        }
    }

    private void redo() {
        if (currMeme < mementos.size() - 1) {
            ++currMeme;
            this.model = mementos.get(currMeme).getModel();
            prompt = true;
        } else {
            System.out.println("No actions to redo.");
        }
    }
*/
    /**
     * A method that removes the states ahead of the current state. 
     */
    private void truncateMemes() {
        if (currMeme < mementos.size() - 1) {
            for (int i = mementos.size() - 1; i > currMeme; --i) {
                mementos.remove(i);
            }
        }
    }

    /**
     * A method that adds a memento to the list. The memento list stores the different states of the model.
     * @param meme state of current model.
     */
    private void newMeme(Memento meme) {
        truncateMemes();
        mementos.add(meme);
        this.model = meme.getModel();
        ++currMeme;
    }

    /**
     * A method that returns the current model.
     * @return	the current model.
     */
    public UMLModel getModel() {
        return model;
    }
    
    
    
}
