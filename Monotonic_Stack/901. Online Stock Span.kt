class StockSpanner() {
    // private val prices = mutableListOf<Int>()
    // private val spans = mutableListOf<Int>()
    // fun next(price: Int): Int {
    //     var span = 1
    //     while (prices.isNotEmpty() && prices.last() <= price){
    //         prices.removeAt(prices.size - 1)
    //         span += spans.removeAt(spans.size - 1)
    //     }
    //     prices.add(price)
    //     spans.add(span)

    //     return span
    // }
    val stack = Stack<Pair<Int,Int>>()
    fun next(price: Int): Int {
        var span = 1
        while(stack.isNotEmpty() && price >= stack.peek().first){
            span += stack.pop().second
        }
        stack.push(price to span)
        
        return span
    }

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * var obj = StockSpanner()
 * var param_1 = obj.next(price)
 */