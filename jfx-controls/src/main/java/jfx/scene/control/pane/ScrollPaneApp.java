/*
 * Copyright (C) 2020 realpai <paiap@outlook.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jfx.scene.control.pane;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import jfx.core.app.ContentBox;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class ScrollPaneApp extends ContentBox {

    public static final boolean SHOWING = false;
    public static final String TITLE = "Pane - ScrollPane 滚动面板";
    private HBox hb;
    private ScrollPane sp;

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        hb = new HBox();
        for (int i = 0; i < 10; i++) {
            hb.getChildren().add(new Button("按钮" + i));
        }

        sp = new ScrollPane();
        sp.setContent(hb);
        sp.setPrefWidth(300);
        this.getChildren().add(sp);
    }
}
