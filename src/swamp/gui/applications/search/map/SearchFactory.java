package swamp.gui.applications.search.map;

import swamp.core.search.framework.GraphSearch;
import swamp.core.search.framework.HeuristicFunction;
import swamp.core.search.framework.QueueSearch;
import swamp.core.search.framework.Search;
import swamp.core.search.framework.TreeSearch;
import swamp.core.search.informed.AStarEvaluationFunction;
import swamp.core.search.informed.AStarSearch;
import swamp.core.search.informed.GreedyBestFirstSearch;
import swamp.core.search.informed.RecursiveBestFirstSearch;
import swamp.core.search.local.HillClimbingSearch;
import swamp.core.search.uninformed.BreadthFirstSearch;
import swamp.core.search.uninformed.DepthFirstSearch;
import swamp.core.search.uninformed.IterativeDeepeningSearch;
import swamp.core.search.uninformed.UniformCostSearch;

/**
 * Useful factory for configuring search objects. Implemented as a singleton.
 * @author Ruediger Lunde
 */
public class SearchFactory {

	/** Search strategy: Depth first search. */
	public final static int DF_SEARCH = 0;
	/** Search strategy: Depth first search. */
	public final static int BF_SEARCH = 1;
	/** Search strategy: Iterative deepening search. */
	public final static int ID_SEARCH = 2;
	/** Search strategy: Uniform cost search. */
	public final static int UC_SEARCH = 3;
	/** Search strategy: Greedy best first search. */
	public final static int GBF_SEARCH = 4;
	/** Search strategy: A* search. */
	public final static int ASTAR_SEARCH = 5;
	/** Search strategy: Recursive best first search. */
	public final static int RBF_SEARCH = 6;
	/** Search strategy: Hill climbing search. */
	public final static int HILL_SEARCH = 7;

	/** Search mode: tree search. */
	public final static int TREE_SEARCH = 0;
	/** Search mode: graph search. */
	public final static int GRAPH_SEARCH = 1;

	/** Contains the only existing instance. */
	private static SearchFactory instance;

	/** Invisible constructor. */
	private SearchFactory() {
	};

	/** Provides access to the factory. Implemented with lazy instantiation. */
	public static SearchFactory getInstance() {
		if (instance == null)
			instance = new SearchFactory();
		return instance;
	}

	/**
	 * Returns the names of all search strategies, which are supported by this
	 * factory. The indices correspond to the parameter values of method
	 * {@link #createSearch(int, int, HeuristicFunction)}.
	 */
	public String[] getSearchStrategyNames() {
		return new String[] { "Depth First", "Breadth First",
				"Iterative Deepening", "Uniform Cost", "Greedy Best First",
				"A*", "Recursive Best First", "Hill Climbing" };
	}

	/**
	 * Returns the names of all search modes, which are supported by this
	 * factory. The indices correspond to the parameter values of method
	 * {@link #createSearch(int, int, HeuristicFunction)}.
	 */
	public String[] getSearchModeNames() {
		return new String[] { "Tree Search", "Graph Search" };
	}

	/**
	 * Creates a search instance.
	 * 
	 * @param strategy
	 *            search strategy. See static constants.
	 * @param mode
	 *            search mode: {@link #TREE_SEARCH} or {@link #GRAPH_SEARCH}
	 * 
	 */
	public Search createSearch(int strategy, int mode, HeuristicFunction hf) {
		QueueSearch qs = null;
		Search result = null;
		switch (mode) {
		case TREE_SEARCH:
			qs = new TreeSearch();
			break;
		case GRAPH_SEARCH:
			qs = new GraphSearch();
		}
		switch (strategy) {
		case DF_SEARCH:
			result = new DepthFirstSearch(qs);
			break;
		case BF_SEARCH:
			result = new BreadthFirstSearch(qs);
			break;
		case ID_SEARCH:
			result = new IterativeDeepeningSearch();
			break;
		case UC_SEARCH:
			result = new UniformCostSearch(qs);
			break;
		case GBF_SEARCH:
			result = new GreedyBestFirstSearch(qs, hf);
			break;
		case ASTAR_SEARCH:
			result = new AStarSearch(qs, hf);
			break;
		case RBF_SEARCH:
			result = new RecursiveBestFirstSearch(new AStarEvaluationFunction(
					hf));
			break;
		case HILL_SEARCH:
			result = new HillClimbingSearch(hf);
			break;
		}
		return result;
	}
}
