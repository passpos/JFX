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
package jfx.scene.image;

import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import jfx.core.app.ContentBox;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class PixelWriterApp extends ContentBox {

    public static final boolean SHOWING = false;
    public static final String TITLE = "Image - PixelWriter接口";
    private PixelWriter pw;

    @Override
    public void index() {
        baseDemo();
    }

    public void baseDemo() {
        Image img = new Image("file:D:/Projects/JavaFX/JFX/jfx-graphics/src/main/resources/imgs/1.jpg");
        WritableImage wi = new WritableImage(img.getPixelReader(), 100, 100, 200, 200);
        pw = wi.getPixelWriter();
    }
}
