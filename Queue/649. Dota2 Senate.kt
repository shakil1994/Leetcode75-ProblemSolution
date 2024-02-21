class Solution {
    fun predictPartyVictory(senate: String): String {
        val radiant = LinkedList<Int>()
        val dire = LinkedList<Int>()

        for (i in 0 until senate.length) {
            (if (senate[i] == 'R') radiant else dire).addLast(i)
        }

        // The voting goes on until voters from one party are all gone
        while (!dire.isEmpty() && !radiant.isEmpty()) {
            
            val voterQ = if (dire.getFirst() < radiant.getFirst()) dire else radiant
            voterQ.addLast(maxOf(dire.getLast(), radiant.getLast()) + 1)
            
            dire.removeFirst()
            radiant.removeFirst()
        }

        // The party with the remaining active voters is the winner
        return if (radiant.isNotEmpty()) "Radiant" else "Dire"
    }
}