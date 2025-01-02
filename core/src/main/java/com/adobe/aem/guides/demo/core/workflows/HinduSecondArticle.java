package com.adobe.aem.guides.demo.core.workflows;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(service = WorkflowProcess.class,property={"process.label=HinduSecondArticle031224"})
public class HinduSecondArticle implements WorkflowProcess{
private static final Logger LOGGER = LoggerFactory.getLogger(HinduSecondArticle.class);
  @Override
  public void execute(WorkItem wItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
   String name = wItem.getMetaDataMap().get("user",String.class);
   String age = wItem.getMetaDataMap().get("Age",String.class);
   LOGGER.info("NAME >>>>>>>>> {}",name);
   LOGGER.info("AGE >>>>>>>>>> {}",age);
  }
}
