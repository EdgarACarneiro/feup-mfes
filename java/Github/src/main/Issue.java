package main;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Issue {
  private String id;
  private Boolean isClosed = false;
  public String title;
  public String description;
  public VDMMap messages = MapUtil.map();
  public VDMSet assignees = SetUtil.set();

  public void cg_init_Issue_1(
      final String issueID, final String issueTitle, final String issueDesc) {

    id = issueID;
    title = issueTitle;
    description = issueDesc;
    return;
  }

  public Issue(final String issueID, final String issueTitle, final String issueDesc) {

    cg_init_Issue_1(issueID, issueTitle, issueDesc);
  }

  public void addMessage(final Message msg) {

    Utils.mapSeqUpdate(messages, msg.id, msg);
  }

  public void assignUser(final User user) {

    assignees = SetUtil.union(Utils.copy(assignees), SetUtil.set(user));
  }

  public void close() {

    isClosed = true;
  }

  public void reopen() {

    isClosed = false;
  }

  public Number numMessages() {

    return MapUtil.dom(Utils.copy(messages)).size();
  }

  public Number numAssignees() {

    return assignees.size();
  }

  public Boolean isIssueClosed() {

    return isClosed;
  }

  public Issue() {}

  public String toString() {

    return "Issue{"
        + "id := "
        + Utils.toString(id)
        + ", isClosed := "
        + Utils.toString(isClosed)
        + ", title := "
        + Utils.toString(title)
        + ", description := "
        + Utils.toString(description)
        + ", messages := "
        + Utils.toString(messages)
        + ", assignees := "
        + Utils.toString(assignees)
        + "}";
  }
}
