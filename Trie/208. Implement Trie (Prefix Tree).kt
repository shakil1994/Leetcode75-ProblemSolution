class Trie() {
    private val root = TrieNode()

    fun insert(word: String) {
        var node = root
        for (char in word) {
            node = node.add(char)
        }
        node.last = true
    }

    fun search(word: String): Boolean {
        var node: TrieNode? = root
        for (char in word) {
            node = node?.child(char)
            if (node == null) return false
        }
        return node?.last == true
    }

    fun startsWith(prefix: String): Boolean {
        var node: TrieNode? = root
        for (char in prefix) {
            node = node?.child(char)
            if (node == null) return false
        }
        return true
    }

    // private class TrieNode{
    //     val children = mutableMapOf<Char, TrieNode>()
    //     var isEndOfWord = false
    // }

    // private val root = TrieNode()

    // fun insert(word: String) {
    //     var node = root
    //     for (char in word) {
    //         if (!node.children.containsKey(char)) {
    //             node.children[char] = TrieNode()
    //         }
    //         node = node.children[char]!!
    //     }
    //     node.isEndOfWord = true
    // }

    // fun search(word: String): Boolean {
    //     var node = root
    //     for (char in word) {
    //         if (!node.children.containsKey(char)) {
    //             return false
    //         }
    //         node = node.children[char]!!
    //     }
    //     return node.isEndOfWord
    // }

    // fun startsWith(prefix: String): Boolean {
    //     var node = root
    //     for (char in prefix) {
    //         if (!node.children.containsKey(char)) {
    //             return false
    //         }
    //         node = node.children[char]!!
    //     }
    //     return true
    // }
}

class TrieNode {

    val map = Array<TrieNode?>(26) { null }
    var last: Boolean = false

    fun add(char: Char): TrieNode {
        val key = char - 'a'
        val child = map[key]
        return when {
            child != null -> child
            else -> {
                val newChild = TrieNode()
                map[key] = newChild
                newChild
            }
        }
    }

    fun child(char: Char): TrieNode? {
        return map[char - 'a']
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */