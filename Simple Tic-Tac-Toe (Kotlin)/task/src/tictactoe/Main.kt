package tictactoe

fun printTable(table: MutableList<MutableList<Char>>) {
    println("---------")
    for (i in table) {
        print("| ")
        for (j in i) {
            print(j+" ")
        }
        println("|")
    }
    println("---------")
}

fun results(table: MutableList<MutableList<Char>>, gamer: Char): String {
    if ((table[0][0] == gamer && table[1][1] == gamer && table[2][2] == gamer) ||
        (table[0][2] == gamer && table[1][1] == gamer && table[2][0] == gamer)) return "$gamer wins"

    var str = ""
    for (i in table) {
        for (n in i) str += n
        if (str == "$gamer$gamer$gamer") return "$gamer wins"
        else str = ""
    }

    for (i in table) {
        for (n in i) str += n
        if (str == "$gamer$gamer$gamer") return "$gamer wins"
        else str = ""
    }

    for (i in 0..2) {
        for (n in table) str += n[i]
        if (str == "$gamer$gamer$gamer") return "$gamer wins"
        else str = ""
    }

    var fullTable: MutableList<Char> = mutableListOf()

    for (i in table){
        for (n in i){
            fullTable.add(n)
        }
    }

    if ('_' !in fullTable) return "Draw"

    return "Game not finished"
}

fun impossible(table: MutableList<MutableList<Char>>): Boolean{
    if( results(table,'X') == "X wins" && results(table,'O') == "O wins") {
        return true
    }
    var contX = 0
    var contO = 0

    for(i in table){
        for(n in i){
            contX += if (n == 'X') 1 else 0
            contO += if (n == 'O') 1 else 0
        }
    }

    if (contX>contO+1 || contO>contX+1) return true

    return false
}

fun main() {
    var table = mutableListOf(
        mutableListOf('_', '_', '_'),
        mutableListOf('_', '_', '_'),
        mutableListOf('_', '_', '_')
    )
    var cont:Int = 0

    val op = readln().toString()
    for (i in 0 until table.size) {
        for (j in 0 until table[i].size) {
            table[i][j] = op[cont]
            cont++
        }
    }

    printTable(table)


    if (results(table,'O') == "Draw" && results(table,'X') == "Draw"){
        println("Draw")
    } else if (impossible(table)){
        println("Impossible")
    } else if (results(table,'X') == "Game not finished" && results(table,'O') == "Game not finished"){
        println("Game not finished")
    } else if (results(table,'X') == "X wins"){
        println(results(table,'X'))
    } else if (results(table,'O') == "O wins"){
    println(results(table, 'O'))
    }
}
