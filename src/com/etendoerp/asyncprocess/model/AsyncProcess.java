/*
 * Copyright 2022  Futit Services SL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.etendoerp.asyncprocess.model;

import java.util.Date;
import java.util.TreeSet;

import com.fasterxml.jackson.annotation.JsonFormat;




public class AsyncProcess {

  private String id;
  @JsonFormat(shape = JsonFormat.Shape.STRING,
    pattern = "dd-MM-yyyy hh:mm:ss")
  private Date lastUpdate;
  private String description;
  private AsyncProcessState state = AsyncProcessState.WAITING;
  private TreeSet<AsyncProcessExecution> executions = new TreeSet<>();

  public AsyncProcess process(AsyncProcessExecution asyncProcessExecution) {
    addExecution(asyncProcessExecution);
    this.id = asyncProcessExecution.getAsyncProcessId();
    this.lastUpdate = asyncProcessExecution.getTime();
    this.state = asyncProcessExecution.getState();
    return this;
  }

  private void addExecution(AsyncProcessExecution transactionClone) {
    executions.add(transactionClone);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AsyncProcessState getState() {
    return state;
  }

  public void setState(AsyncProcessState state) {
    this.state = state;
  }

  public TreeSet<AsyncProcessExecution> getExecutions() {
    return executions;
  }

  public void setExecutions(TreeSet<AsyncProcessExecution> executions) {
    this.executions = executions;
  }
}
