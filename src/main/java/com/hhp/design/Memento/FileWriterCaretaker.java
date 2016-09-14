package com.hhp.design.Memento;

/**
 * Created by huanghaopeng on 16/9/14.
 */
public class FileWriterCaretaker {

    private Object obj;

    public void save(FileWriterUtil fileWriter){
        this.obj=fileWriter.save();
    }

    public void undo(FileWriterUtil fileWriter){
        fileWriter.undoToLastSave(obj);
    }
}
