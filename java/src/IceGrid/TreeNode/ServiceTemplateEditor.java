// **********************************************************************
//
// Copyright (c) 2003-2005 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
package IceGrid.TreeNode;

import javax.swing.JFrame;

import com.jgoodies.forms.builder.DefaultFormBuilder;

class ServiceTemplateEditor extends TemplateEditor
{
    ServiceTemplateEditor(JFrame parentFrame)
    {
	super(parentFrame);
	_subEditor = new ServiceSubEditor(this, parentFrame);
    }
    
    void writeDescriptor()
    {
	super.writeDescriptor();
	_subEditor.writeDescriptor();
    }	    

    boolean isSimpleUpdate()
    {
	return super.isSimpleUpdate() && _subEditor.isSimpleUpdate();
    }

    void appendProperties(DefaultFormBuilder builder)
    { 
	super.appendProperties(builder);
	builder.appendSeparator();
	builder.nextLine();
	_subEditor.appendProperties(builder);
    }

    void show(ServiceTemplate t)
    {
	detectUpdates(false);
	setTarget(t);
	
	super.show();
	_subEditor.show(true);

	_applyButton.setEnabled(t.isEphemeral());
	_discardButton.setEnabled(t.isEphemeral());	  
	detectUpdates(true);
    }

    private ServiceSubEditor _subEditor;
}
