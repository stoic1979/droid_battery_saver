/*
 * Copyright (C) 2014 IUH �yber$oft Team
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package vn.cybersoft.obs.android.models;

/**
 * @author Luan Vu
 *
 */
public class MainMenuListRow {
	public int id;
	public int imageRes;
	public String caption;
	
	/**
	 * @param id
	 * @param imageRes
	 * @param caption
	 */
	public MainMenuListRow(int id, int imageRes, String caption) {
		super();
		this.id = id;
		this.imageRes = imageRes;
		this.caption = caption;
	}
	
}
