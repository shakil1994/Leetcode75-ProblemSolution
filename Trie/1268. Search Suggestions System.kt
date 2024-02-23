// class TrieNode{
//     val children = mutableMapOf<Char, TrieNode>()
//     val suggestions = mutableListOf<String>()
// }
class Solution {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        // val root = TrieNode()

        // // Insert all products into the Trie
        // for(product in products){
        //     var node = root
        //     for(char in product){
        //         node.children.computeIfAbsent(char){TrieNode()}
        //         node = node.children[char]!!
        //         node.suggestions.add(product)
        //     }
        // }
        // val result = mutableListOf<List<String>>()
        // var node: TrieNode? = root
        // for(char in searchWord){
        //     node = node?.children?.get(char)
        //     result.add(node?.suggestions?.sorted()?.take(3) ?: emptyList())
        // }
        // return result

        products.sort()

        val result: MutableList<List<String>> = mutableListOf()

        var leftPtr = 0
        var rightPtr = products.size - 1

        for ((index, char) in searchWord.withIndex()) {

            while (leftPtr <= rightPtr && (products[leftPtr].length <= index || products[leftPtr][index] != char)) {
                leftPtr++
            }

            while (rightPtr >= leftPtr && (products[rightPtr].length <= index || products[rightPtr][index] != char)) {
                rightPtr--
            }

            if (leftPtr > rightPtr) {
                result.add(emptyList())
                continue
            } else {
                var list = mutableListOf<String>()
                var numWords = 0

                var current = leftPtr

                while (numWords < 3 && current <= rightPtr) {
                    list.add(products[current++])
                    numWords++
                }

                result.add(list.toList())
            }
        }

        return result.toList()
    }
}