package swamp.core.agent.impl;

import swamp.core.agent.Action;
import swamp.core.agent.Agent;
import swamp.core.agent.EnvironmentState;
import swamp.core.agent.EnvironmentView;

/**
 * Simple environment view which uses the standard output stream to inform about
 * relevant events.
 * 
 * @author Ruediger Lunde
 */
public class SimpleEnvironmentView implements EnvironmentView {
	@Override
	public void agentActed(Agent agent, Action action,
			EnvironmentState resultingState) {
		System.out.println("Agent acted: " + action.toString());
	}

	@Override
	public void agentAdded(Agent agent, EnvironmentState resultingState) {
		System.out.println("Agent added.");
	}

	@Override
	public void notify(String msg) {
		System.out.println("Message: " + msg);
	}
}
