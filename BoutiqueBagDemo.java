
public class BoutiqueBagDemo {

	public static void main(String[] args) {
		
		/**This is a test of the constructor to add a bag with default capacity.
		 * The bag is initially empty and is not filled to capacity.
		 * After items are added to the bag an additional item is added as a test.
		 */
		System.out.println("Testing an empty bag with sufficient capacity:");
		BagInterface<String> aBag = new ClothingBag<>();
		String[] bagItems = {"Shirt", "Polo", "Dress", "Skirt", "Hat"};
		testAdd(aBag, bagItems);
		System.out.println();
		String name = "Glasses";
		System.out.println("Adding one more string to the first bag.");
		addOne(aBag, name);
		System.out.println();
		
		/**This is a test of the constructor to add a bag with a specified capacity.
		 * The bag is initially empty and is filled to capacity.
		 * After items are added to the bag an additional item is added as a test.
		 */
		System.out.println("Testing a second empty bag that will be filled to capacity:");
		aBag = new ClothingBag<>(7);
		String[] bagItems2 = {"Shirt", "Polo", "Dress", "Skirt", "Hat", "Polo", "Scarf"};
		testAdd(aBag, bagItems2);
		System.out.println();
		System.out.println("Adding one additional item to the same bag.");
		addOne(aBag, name);
		System.out.println();
		
		/**This is a test of the constructor to add a bag with a specified capacity
		 * greater than is allowed by the ClothingBag constructor.
		 */
		System.out.println("Testing creating a bag over the maximum size allowed:");
		aBag = new ClothingBag<>(10001);
	}
	
	/**This tests the add method using an array of elements.
	 * @param aBag is the bag created.
	 * @param bagItems is the array of elements being passed into the bag.
	 */
	private static void testAdd(BagInterface<String> aBag, String[] bagItems) {
		System.out.print("Adding the following strings to the bag: ");
		
		for (int i = 0; i < bagItems.length; i++) {
			if (aBag.add(bagItems[i])) {
				System.out.print(bagItems[i] + " ");
			} else {
				System.out.print("Unable to add " + bagItems[i] + " to the bag.");
			}
		}
		System.out.println();
		System.out.println();
		displayBag(aBag);
	}
	
	/**This test adding one additional element to the bag.
	 * @param aBag is the bag created holding the elements.
	 * @param name is the String element being passed into the bag.
	 */
	private static void addOne(BagInterface<String> aBag, String name) {
			if (aBag.add(name)) {
				System.out.print(name + " has been added to the bag.");
			} else {
				System.out.print("Unable to add " + name + " to the bag. The bag is full.");
			}
		System.out.println();
		System.out.println();
		displayBag(aBag);
	}
	
	/**This tests the toArray() method while displaying the bag.
	 * @param aBag is the bag of elements.
	 */
	private static void displayBag(BagInterface<String> aBag) {
		System.out.println("The bag contains the following string(s): ");
		Object[] bagArray = aBag.toArray();
		
		for (int i = 0; i < bagArray.length; i++) {
			System.out.print(bagArray[i] + " ");
		}
		System.out.println();
	}
}
