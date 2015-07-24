package ScrabbleTeam3;

	class Word implements Comparable<Word>
	{
		String value;
		int key;
		int length;
		
		public Word(String value, int key)
		{
			this.value = value;
			this.key = key;
			this.length = value.length();
		}
		@Override
		public int compareTo(Word o)
		{
			if(this.key == o.key)
			{
				return (this.value.compareTo(o.value));
			}
			return o.key-this.key;
		}
	}

