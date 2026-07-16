class WordDictionary {
    private words: string[] = [];

    addWord(word: string): void {
        this.words.push(word);
    }

    search(word: string): boolean {
        return this.words.includes(word);
    }
}

const wordDictionary = new WordDictionary();
wordDictionary.addWord('bad');
wordDictionary.addWord('dad');
wordDictionary.addWord('mad');
console.log(wordDictionary.search('pad')); // return False
console.log(wordDictionary.search('bad')); // return True
console.log(wordDictionary.search('.ad')); // return True
console.log(wordDictionary.search('b..')); // return True