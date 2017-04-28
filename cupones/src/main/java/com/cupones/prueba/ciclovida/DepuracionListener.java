package com.cupones.prueba.ciclovida;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DepuracionListener implements javax.faces.event.PhaseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(DepuracionListener.class);

	
	public void afterPhase(PhaseEvent phaseEvent) {
		if (log.isInfoEnabled()) {
			log.info("AFTER PHASE: " + phaseEvent.getPhaseId().toString());
		}
	}

	
	public void beforePhase(PhaseEvent phaseEvent) {
		if (log.isInfoEnabled()) {
			log.info("BEFORE PHASE: " + phaseEvent.getPhaseId().toString());
		}
	}

	
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}