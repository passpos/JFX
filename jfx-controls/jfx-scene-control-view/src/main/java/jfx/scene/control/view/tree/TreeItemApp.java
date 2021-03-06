/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfx.scene.control.view.tree;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import jfx.core.app.ContentBox;
import utils.entity.demo.sample.Person;

/**
 * TreeItem 是TreeView下的节点
 *
 * TreeItem不是节点类型，所以不会在TreeItem上触发任何视觉事件。为了获得这些事件，
 * 有必要将相关的观察者（Observable）添加到TreeCell实例中（通过自定义单元工厂）。
 *
 * 属性：expanded、graphic、leaf、parent、view
 *
 * 事件体系结构：
 * TreeItem.treeNotificationEvent()
 * - TreeItem.valueChangedEvent()
 * - TreeItem.graphicChangedEvent()
 * - TreeItem.expandedItemCountChangeEvent()
 * ---- TreeItem.branchExpandedEvent()
 * ---- TreeItem.branchCollapsedEvent()
 * ---- TreeItem.childrenModificationEvent()
 *
 * 1. 当激发子类型事件时，父类型事件也会被激发，建议仅监听需要的子事件；
 * 2. 直接对根节点设置事件处理，那么对子节点的操作，会将事件传递到根节点，从而得到
 * 事件的响应；
 * 3. 事件可以被事件处理器（EventHandler）处理，所以，TreeItem的两个方法：
 * - addEventHandler()
 * - removeEventHandler()
 * 十分重要；
 *
 * @author passpos <paiap@outlook.com>
 */
public class TreeItemApp extends ContentBox {

    public static final boolean SHOWING = false;
    public static final String TITLE = "Tree - TreeItem";
    public TreeView<String> tv;
    private TreeItem<String> root;

    @Override
    public void index() {
        baseDemo();
        objectValueDemo();
        valueChangEvent();
        countChangeEvenet();
    }

    public void baseDemo() {
        String str = "中国";
        root = new TreeItem<>(str);
        root.setExpanded(true);

        // 节点的文本值
        root.setValue("China");

        // 用于设置节点图标等操作
        root.setGraphic(new Button(str));

        // 节点下是否为空；
        ol("isLeaf() - " + root.isLeaf());

        // root的上个节点为空
        ol("previousSibling() - " + root.previousSibling());

        // 当前节点的下个节点
        ol("nextSibling() - " + root.nextSibling());

        // root的父节点为空
        ol("getParent() - " + root.getParent());

        // 子节点
        ol("getChildren() - " + root.getChildren());

        tv = new TreeView<>();
        tv.setRoot(root);
        tv.setPrefHeight(50);
        getChildren().add(tv);
    }

    /**
     * 显示对象类型的数据
     */
    public void objectValueDemo() {
        TreeView<Person> trv = new TreeView<>();

        StringConverter<Person> strc;
        Callback<TreeView<Person>, TreeCell<Person>> callback;

        strc = new StringConverter<Person>() {
            @Override
            public String toString(Person t) {
                return t.getName() + t.getAge();
            }

            @Override
            public Person fromString(String string) {
                Person p = new Person(string, 0);
                return p;
            }
        };
        callback = TextFieldTreeCell.forTreeView(strc);

        trv.setCellFactory(callback);
        Person p = new Person("福瑞", 18);

        TreeItem<Person> ti = new TreeItem<>(p);
        trv.setRoot(ti);
        trv.setPrefHeight(50);

        getChildren().add(trv);
        setTopAnchor(trv, 100.0);
    }

    /**
     * 值改变事件
     */
    public void valueChangEvent() {
        Button b = new Button("值改变事件 - 点击");
        getChildren().add(b);
        setLeftAnchor(b, 300.0);
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                root.setValue("newName");
            }
        });
        EventHandler<TreeItem.TreeModificationEvent<String>> eh = new EventHandler<>() {
            @Override
            public void handle(TreeItem.TreeModificationEvent<String> t) {
                ol(t.getNewValue());
            }
        };
        root.addEventHandler(TreeItem.<String>valueChangedEvent(), eh);
    }

    /**
     * 父节点下展开项数量的变化事件
     */
    public void countChangeEvenet() {
        EventHandler<TreeItem.TreeModificationEvent<String>> eh = new EventHandler<>() {
            @Override
            public void handle(TreeItem.TreeModificationEvent<String> t) {
            }
        };
        root.addEventHandler(TreeItem.expandedItemCountChangeEvent(), eh);
    }

}
