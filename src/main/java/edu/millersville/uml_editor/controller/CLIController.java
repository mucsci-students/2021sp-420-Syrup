package edu.millersville.uml_editor.controller;

import java.io.IOException;

import org.jline.reader.LineReader;
import org.jline.reader.impl.completer.AggregateCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.CLIView;
import edu.millersville.uml_editor.view.TabCompleter;

public class CLIController {

    private Terminal terminal;
    private UMLModel model;
    private CLIView view;

    private AggregateCompleter completer;
    private LineReader reader;

    public CLIController(UMLModel model, CLIView view) throws IOException {
        this.model = model;
        this.view = view;

        terminal = TerminalBuilder.builder().system(true).build();
        completer = new TabCompleter().updateCompleter(model);
        reader = LineReaderBuilder.builder().terminal(terminal).completer(completer).variable(LineReader.MENU_COMPLETE, true).build();
    }
}
