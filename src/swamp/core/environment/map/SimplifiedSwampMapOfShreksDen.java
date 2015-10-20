package swamp.core.environment.map;

public class SimplifiedSwampMapOfShreksDen extends ExtendableMap {
	
	public SimplifiedSwampMapOfShreksDen() {
		initMap(this);
	}
	
	public static String INITIAL = "Source,0";
	public static String FINAL = "Sink";
	
	public static void initMap(ExtendableMap map) {
		map.clear();
		Swamp swamp = new Swamp(8, 8, 0.5,0.2);
		System.out.println(swamp);
		FINAL = "Sink," + swamp.getCols();
		boolean mud = false;
		boolean nextMud = false;
		for (int i = 0; i < swamp.getRows(); i++) {
			for (int j = 0; j < swamp.getCols(); j++) {
				if ( swamp.land(i, j) ) {
					mud = swamp.mud(i, j);
					if ( j == 0 ) {
						map.addUnidirectionalLink(INITIAL,i + "," + j  + "," + ( mud ? "M" : "L") ,mud ? 5.0 : 1.0); }
					if ( j == swamp.getCols() - 1 ) {
						map.addUnidirectionalLink(i + "," + j + "," + ( mud ? "M" : "L"), FINAL, 1.0);
					}
					if (swamp.land(i+1, j)) {
						nextMud = swamp.mud(i+1, j);
						map.addUnidirectionalLink(i + "," + j + "," + (mud ? "M" : "L"),(i+1) + "," + j + "," + (nextMud ? "M" : "L"),
												  nextMud ? 5.0 : 1.0);
					}
					if (swamp.land(i-1, j)) {
						nextMud = swamp.mud(i-1, j);
						map.addUnidirectionalLink(i + "," + j + "," + ( mud ? "M" : "L"),(i-1) + "," + j + "," + (nextMud ? "M" : "L"),
								                  nextMud ? 5.0 : 1.0);
					}
					if (swamp.land(i+1, j+1)) {
						nextMud = swamp.mud(i+1, j+1);
						map.addUnidirectionalLink(i + "," + j + "," + ( mud ? "M" : "L"),(i+1) + "," + (j+1) + "," + (nextMud ? "M" : "L"), 
								                  nextMud ? 5.0 : 1.0);
					}
					if (swamp.land(i-1, j+1)) {
						nextMud = swamp.mud(i-1, j+1);
						map.addUnidirectionalLink(i + "," + j + "," + ( mud ? "M" : "L"),(i-1) + "," + (j+1) + "," + (nextMud ? "M" : "L"),
								                  nextMud ? 5.0 : 1.0);
					}
					if (swamp.land(i+1, j-1)) {
						nextMud = swamp.mud(i+1, j-1);
						map.addUnidirectionalLink(i + "," + j + "," + ( mud ? "M" : "L"),(i+1) + "," + (j-1) + "," + (nextMud ? "M" : "L"), 
								                  nextMud ? 5.0 : 1.0);
					}
					if (swamp.land(i-1, j-1)) {
						nextMud = swamp.mud(i-1, j-1);
						map.addUnidirectionalLink(i + "," + j + "," + ( mud ? "M" : "L") ,(i-1) + "," + (j-1) + "," + (nextMud ? "M" : "L"), 
								                  nextMud ? 5.0 : 1.0);
					}
					if (swamp.land(i, j-1)) {
						nextMud = swamp.mud(i, j-1);
						map.addUnidirectionalLink(i + "," + j + "," + ( mud ? "M" : "L") ,i + "," + (j-1) + "," + (nextMud ? "M" : "L"), 
								                  nextMud ? 5.0 : 1.0);
					}
					if (swamp.land(i, j+1)) {
						nextMud = swamp.mud(i, j+1);
						map.addUnidirectionalLink(i + "," + j + "," + ( mud ? "M" : "L"),i + "," + (j+1) + "," + (nextMud ? "M" : "L"), 
								                  nextMud ? 5.0 : 1.0);
					}
				}
			}
		}
		map.setPosition(INITIAL, 0, 170);
		map.setPosition(FINAL, 2600, 170);
		int ratio = 2200/swamp.getCols();
		int tmp1 = ratio;
		int tmp2 = 0;
		mud = false;
		for (int i = 0; i < swamp.getRows(); i++) {
			for (int j = 0; j < swamp.getCols(); j++) {
				mud = swamp.mud(i, j);
				map.setPosition(i+","+j + "," + (mud ? "M" : "L"),tmp1, tmp2);
				tmp1 = tmp1 + ratio;
			}
			tmp1 = ratio;
			tmp2 = tmp2 + 330;
		}
	}
	
	
}
