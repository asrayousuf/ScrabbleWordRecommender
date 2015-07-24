package ScrabbleTeam3;

	class Word implements Comparable<Word>
	{
		String scoredWord;
		int score;
		int length;
		
		public Word(String value, int key)
		{
			this.scoredWord = value;
			this.score = key;
			this.length = value.length();
		}
		@Override
		public int compareTo(Word o)
		{
			if(this.score == o.score)
			{
				return (this.scoredWord.compareTo(o.scoredWord));
			}
			return o.score-this.score;
		}
	}

