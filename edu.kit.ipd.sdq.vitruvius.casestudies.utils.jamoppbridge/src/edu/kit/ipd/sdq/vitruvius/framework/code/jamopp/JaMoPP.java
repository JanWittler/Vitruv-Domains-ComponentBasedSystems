/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package edu.kit.ipd.sdq.vitruvius.framework.code.jamopp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.java.JavaPackage;
import org.emftext.language.java.resource.JavaSourceOrClassFileResourceFactoryImpl;
import org.emftext.language.java.resource.java.IJavaOptions;

/**
 * Registers the {@link JavaSourceOrClassFileResourceFactoryImpl} to load JaMoPP resources from
 * .java files or java content-type InputStreams.
 */
public class JaMoPP {

    private final ResourceSet rs;

    public JaMoPP() {
        this.rs = new ResourceSetImpl();
        setUp();
    }

    public ResourceSet getResourceSet() {
        return this.rs;
    }

    protected void setUp() {
        this.rs.getLoadOptions().put(IJavaOptions.DISABLE_LOCATION_MAP, Boolean.TRUE);
        EPackage.Registry.INSTANCE.put("http://www.emftext.org/java", JavaPackage.eINSTANCE);
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("java",
                new JavaSourceOrClassFileResourceFactoryImpl());
        Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap().put("java",
                new JavaSourceOrClassFileResourceFactoryImpl());
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
                new XMIResourceFactoryImpl());
    }

    protected void parseResource(File file) throws IOException {
        loadResource(file.getCanonicalPath());
    }

    protected void loadResource(String filePath) throws IOException {
        loadResource(URI.createFileURI(filePath));
    }

    protected void loadResource(URI uri) throws IOException {
        this.rs.getResource(uri, true);
    }

    // in-memory loading
    protected void loadResource(URI uri, InputStream in) throws IOException {
        // rs.getResource(uri, true);
        Resource r = this.rs.createResource(uri, "java");
        r.load(in, null);
    }
}
