
public final class ClothingBag<MyType> implements BagInterface<MyType> {

	private final MyType[] myBag;
	private static final int DEFAULT_CAPACITY = 10;
	private int numberOfProducts;
	private boolean integrityOK;
	private static final int MAX_CAPACITY = 10000;
	
	/**This default constructor creates an empty bag with capacity 10
	 */
	public ClothingBag() {
		this(DEFAULT_CAPACITY);
	}
	
	/**This constructor creates an empty bag with a stated capacity.
	 * @param capacity is the integer that determines the capacity.
	 * This constructor throws an exception for a bag outside of the maximum limit set.
	 */
	public ClothingBag(int capacity) {
		integrityOK = false;
		if (capacity <= MAX_CAPACITY) {
		numberOfProducts = 0;
		
		//This cast is safe since the new array contains null entries.
		@SuppressWarnings("unchecked")
		MyType[] tempBag = (MyType[]) new Object[capacity];
		myBag = tempBag;
		integrityOK = true;
		} 
		else {
			throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum.");
		}
	}

	/**This method calls isFull() and checks to see if the bag is full.
	 * If the bag is not full it adds the item to the bag and increments the index.
	 */
	@Override
	public boolean add(MyType anEntry) {
		checkIntegrity();
		boolean result = true;
		if(isFull()) {
			result = false;
		} else {
			myBag[numberOfProducts] = anEntry;
			numberOfProducts++;
			}
		return result;
		}
	
	/**This method checks to see if the bag is full.
	 */
	@Override
	public boolean isFull() {
		return numberOfProducts >= myBag.length;
	}
	
	/**This method retrieves all items in the bag.
	 * @return A new allocated array of all entries in the bag
	 */
	@Override
	public MyType[] toArray() {
		checkIntegrity();
		
		//This cast is safe since the new array contains null entries.
		@SuppressWarnings("unchecked")
		MyType[] result = (MyType[]) new Object[numberOfProducts];
		
		for (int i = 0; i < numberOfProducts; i++) {
			result[i] = myBag[i];
		}
		return result;
	}
	
	private void checkIntegrity() {
		if (!integrityOK) {
			throw new SecurityException("myBag object is corrupt.");
		}
	}

}
