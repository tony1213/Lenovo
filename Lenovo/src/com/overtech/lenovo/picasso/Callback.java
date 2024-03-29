/*
 * Copyright (C) 2013 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.overtech.lenovo.picasso;

public interface Callback {
  void onSuccess();

  void onError();
  
  void onChangeProgress(int progress);

  public static class EmptyCallback implements Callback {

    @Override public void onSuccess() {
    }

    @Override public void onError() {
    }

	@Override
	public void onChangeProgress(int progress) {
	}

  }
}
