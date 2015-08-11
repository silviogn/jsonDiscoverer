/*******************************************************************************
 * Copyright (c) 2008, 2015
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Javier Canovas (me@jlcanovas.es) 
 *******************************************************************************/


package jsondiscoverer.util;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * Utility class con basic model actions
 * 
 * @author Javier Canovas (me@jlcanovas.es)
 * @version 1.0.0
 *
 */
public class ModelHelper {
	

	public static void saveEPackage(EPackage ePackage, File resultPath) {
		ResourceSet rset = new ResourceSetImpl();
		Resource res = rset.createResource(URI.createFileURI(resultPath.getAbsolutePath()));

		try {
			res.getContents().add(ePackage);
			res.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static EPackage loadEPackage(File path) {
		ResourceSet rset = new ResourceSetImpl();
		Resource res = rset.getResource(URI.createFileURI(path.getAbsolutePath()), true);

		try {
			res.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return (EPackage) res.getContents().get(0);
	}

}
