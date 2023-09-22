import java.io.File

val hangman = listOf("""
    ┌────┬
    │    │
    │    O
    │  ──┼──
    │    │
    │   / \
    └────────
""".trimIndent(),"""
    ┌────┬
    │    │
    │    O
    │  ──┼──
    │    │
    │   
    └────────
""".trimIndent(),"""
    ┌────┬
    │    │
    │    O
    │  ──┼──
    │    
    │   
    └────────
""".trimIndent(),"""
    ┌────┬
    │    │
    │    O
    │   ─┼─
    │    
    │   
    └────────
""".trimIndent(),"""
    ┌────┬
    │    │
    │    O
    │  
    │   
    │   
    └────────
""".trimIndent(),"""
    ┌────┬
    │    │
    │    
    │  
    │   
    │   
    └────────
""".trimIndent(),"""
    ┌────┬
    │    
    │    
    │  
    │   
    │   
    └────────
""".trimIndent(),"""
    
    │   
    │   
    │  
    │   
    │   
    └────────
""".trimIndent(),"""





    
─────────
""".trimIndent())

fun main(){
    val word = File("words.txt").readLines().random()
    var status = ".".repeat(word.length).toCharArray()
    var life = hangman.lastIndex
    println(word)
    
    println(life)

    while(life > 0 && String(status) != word){
        println(status)
        println(hangman[hangman.lastIndex]);
        
        var input = readLine()!!
        println(input)
        life--

        if (input.length > 1){
            if (input == word){
                status = input.toCharArray()
            }
            else{
                life--
            }
        }
        else if (input in word){
            word.forEachIndexed(index,  c ->
                if (c in input)
                    status[index] = c
                    )
        }
        else
            life--
    }
    if (life > 0){
        println("You have won!");
    }
    else {
        println("You have failed! The word was '"+word+"'.")
    }

    println("OVER")
}