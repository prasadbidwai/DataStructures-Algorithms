class HashMap
{
	private static final int maxsize = 128
	HashEntry[] table;

	public HashMap()
	{
		table = new HashEntry[maxsize];
		for (int i = 0 ;i < maxsize ; i++) 
		{
			table[i] = null;	
		}
	}

	public int getHashValue(int key)
	{
		int hashVal = key%maxsize;

		while(table[hashVal] != null && table[hashVal].getKey != key)
		{
			hashVal = (hashVal+1)%maxsize;
		}
	return hashVal;
	}

	public void put(int key, int value)
	{
		int hashVal = getHashValue(key);

		table[hashVal] = new HashEntry(key, value);
	}

	public HashEntry get(int key)
	{
		int hashVal = getHashValue(key);

		if (table[hashVal] == null) 
		{
			return -1;
		}
		else
		{
			return table[hashVal].getValue();
		}
	}
}
