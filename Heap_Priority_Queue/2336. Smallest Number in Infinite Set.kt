class SmallestInfiniteSet() {
    private var current = 1
    // private val set = TreeSet<Int>()
    private val set: TreeSet<Int> = TreeSet()
    fun popSmallest(): Int {
        if (set.isEmpty()) {
            return current++
        }
        val smallest = set.first()
        set.remove(smallest)
        return smallest
        
    }

    fun addBack(num: Int) {
        if(num < current){
            set.add(num)
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * var obj = SmallestInfiniteSet()
 * var param_1 = obj.popSmallest()
 * obj.addBack(num)
 */