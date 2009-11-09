/*
    Copyright 2008-2009 Josh Drummond

    This file is part of WebPasswordSafe.

    WebPasswordSafe is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    WebPasswordSafe is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with WebPasswordSafe; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/
package com.joshdrummond.webpasswordsafe.client.remote;

import java.util.List;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.joshdrummond.webpasswordsafe.common.model.Password;
import com.joshdrummond.webpasswordsafe.common.model.Tag;


/**
 * 
 * @author Josh Drummond
 *
 */
public interface PasswordService extends RemoteService {
    
    public void addPassword(Password password);
    public void updatePassword(Password password);
    public List<Password> searchPassword(String query);
    public String generatePassword();
    public String getCurrentPassword(long passwordId);
    public List<Tag> getAvailableTags();
    public Password getPassword(long passwordId);
    
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PasswordServiceAsync instance;
		public static PasswordServiceAsync getInstance(){
			if (instance == null) {
				instance = (PasswordServiceAsync) GWT.create(PasswordService.class);
				ServiceDefTarget target = (ServiceDefTarget) instance;
				target.setServiceEntryPoint(GWT.getModuleBaseURL() + "rpc/PasswordService");
			}
			return instance;
		}
	}
}
