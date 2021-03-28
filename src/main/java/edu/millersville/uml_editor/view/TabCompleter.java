package edu.millersville.uml_editor.view;

import org.jline.reader.impl.completer.AggregateCompleter;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.NullCompleter;
import org.jline.reader.impl.completer.StringsCompleter;

public class TabCompleter {

    private AggregateCompleter completer;

    public TabCompleter() {
        this.completer = new AggregateCompleter(
            new ArgumentCompleter(
                new StringsCompleter("add"),
                new StringsCompleter("class", "field", "method", "parameter"),
                new NullCompleter()
            ),
            new ArgumentCompleter(
                new StringsCompleter("add"),
                new StringsCompleter("rel"),
                new StringsCompleter("AGGREGATION", "COMPOSITION", "INHERITANCE", "REALIZATION"),
                new NullCompleter()
            ),
            new ArgumentCompleter(
                new StringsCompleter("save", "load", "quit"),
                new NullCompleter()
            ),
            new ArgumentCompleter(
                new StringsCompleter("print"),
                new StringsCompleter("classes", "relationships", "all"),
                new NullCompleter()
            )
        );
    }
}
