package edu.millersville.uml_editor.controller;

import java.io.IOException;

import org.jline.builtins.Completers.TreeCompleter;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.AggregateCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import edu.millersville.uml_editor.Commands.AddCommand;
import edu.millersville.uml_editor.Commands.LoadCommand;
import edu.millersville.uml_editor.Commands.PrintCommand;
import edu.millersville.uml_editor.Commands.RemoveCommand;
import edu.millersville.uml_editor.Commands.RenameCommand;
import edu.millersville.uml_editor.Commands.SaveCommand;
import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.CLIView;
import edu.millersville.uml_editor.view.TabCompleter;

public class CLIController {

    private Terminal terminal;
    private UMLModel model;
    private CLIView view;

    private TabCompleter completer;
    private LineReader reader;

    public CLIController(UMLModel model, CLIView view) throws IOException {
        this.model = model;
        this.view = view;

        terminal = TerminalBuilder.builder().system(true).build();
        completer = new TabCompleter();
        reader = LineReaderBuilder.builder().terminal(terminal).completer(completer).variable(LineReader.MENU_COMPLETE, true).build();
    }

    public void parseCommand(String[] commands) {

        switch(commands[0]) {
            case "add":
            AddCommand add = new AddCommand(model, view, commands);
            break;

            case "save":
            SaveCommand save = new SaveCommand();
            break;

            case "load":
            LoadCommand load = new LoadCommand();
            break;

            case "print":
            PrintCommand print = new PrintCommand();
            break;

            case "remove":
            RemoveCommand remove = new RemoveCommand();
            break;

            case "rename":
            RenameCommand rename = new RenameCommand();
            break;

            default:
            // TODO
        }
    }
}
