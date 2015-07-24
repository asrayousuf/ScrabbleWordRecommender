package ScrabbleTeam3;

class Word implements Comparable<Word> {
	private String word;
	private int score;
	private int length;

	public Word(String word, int score) {
		this.word = word;
		this.score = score;
		this.length = word.length();
	}

	public void setWord(String word) {
		this.word = word;
		this.length = word.length();
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getWord() {
		return this.word;
	}

	public int getScore() {
		return this.score;
	}

	public int getLength() {
		return this.length;
	}

	@Override
	public int compareTo(Word o) {
		if (this.score == o.score) {
			return (this.word.compareTo(o.word));
		}
		return o.score - this.score;
	}
}
