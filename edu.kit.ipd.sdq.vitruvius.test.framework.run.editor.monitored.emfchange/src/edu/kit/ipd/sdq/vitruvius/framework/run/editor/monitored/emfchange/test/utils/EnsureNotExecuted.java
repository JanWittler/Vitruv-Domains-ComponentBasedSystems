package edu.kit.ipd.sdq.vitruvius.framework.run.editor.monitored.emfchange.test.utils;

public class EnsureNotExecuted {
    private boolean hasExecuted = false;
    
    public void markExecuted() {
        hasExecuted = true;
    }
    
    public boolean isIndicatingFail() {
        return hasExecuted;
    }
}
