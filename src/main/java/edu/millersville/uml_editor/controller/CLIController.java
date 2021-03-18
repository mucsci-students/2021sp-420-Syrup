package edu.millersville.uml_editor.controller;

import org.jline.terminal.Terminal;

public class CLIController {

    private Terminal terminal;
    
    public static void main(String[] args) {

        terminal = TerminalBuilder.builder().system(true).build();
    }
}
