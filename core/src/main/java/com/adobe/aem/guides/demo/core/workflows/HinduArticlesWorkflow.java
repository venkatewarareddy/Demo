package com.adobe.aem.guides.demo.core.workflows;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(service = WorkflowProcess.class,immediate = true,property={"process.label=HinduArticleWorkflow031224"})
public class HinduArticlesWorkflow implements WorkflowProcess{

private static final Logger LOG = LoggerFactory.getLogger(HinduArticlesWorkflow.class);
 
  @Override
  public void execute(WorkItem wItem, WorkflowSession wSession, MetaDataMap metaDataMap) throws WorkflowException {
     LOG.info("Inside Execute >>>>>>>>");
      String payLoadType =  wItem.getWorkflowData().getPayloadType();
      if(payLoadType.equals("JCR_PATH")){
        LOG.info("payLoadType {}",payLoadType);
        String path = wItem.getWorkflowData().getPayload().toString();
        LOG.info("path {}",path);
      }   
            //String arguments = metaDataMap.get("PROCESS_ARGS", String.class);
            //LOG.info("Process args: {}", arguments);
            //LOG.error("PracticeCustomWorkflowProcess called >>>>>>>>");
           // wItem.getWorkflow().getMetaDataMap().put("user", "VENKAT");
           // wItem.getWorkflow().getMetaDataMap().put("Age", "25");
  }

}
