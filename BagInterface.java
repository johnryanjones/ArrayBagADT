
public interface BagInterface<MyType> {
	
	/**Adds a new entry to this bag.
	 * @param anEntry is the object to be added.
	 * @return true or false if the addition was successful.
	 */
	public boolean add(MyType anEntry);
	
	/**Checks to see if the bag is full.
	 * @return true or false
	 */
	public boolean isFull();
	
	/**Retrieves all entries that are in this bag.
	 * @return a new allocated array of all entries in this bag.
	 * The returned array is empty if the bag is empty.
	 */
	public MyType[] toArray();
}
