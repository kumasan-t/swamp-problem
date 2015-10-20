package swamp.core.agent.impl;

import swamp.core.agent.State;

/**
 * @author Ciaran O'Reilly
 */
public class DynamicState extends ObjectWithDynamicAttributes implements State {
	public DynamicState() {

	}

	@Override
	public String describeType() {
		return State.class.getSimpleName();
	}
}