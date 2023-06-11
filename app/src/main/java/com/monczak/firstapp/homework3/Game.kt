package com.monczak.firstapp.homework3

// This package needs refactor and class separation


class Game {
    val characterContainer = Container<Character>()
    val playerContainer = Container<Player>()
    val professionContainer = Container<Mage>()

    val player1 = Player("Player1", 10)
    val player2 = Player("Player2", 20)

    val mage1 = Mage("Mage1", 21)
    val mage2 = Mage("Mage2", 37)

//    playerContainer.list.add(player1)
//    playerContainer.list.add(player2)
//
//    professionContainer.list.add(mage1)
//    professionContainer.list.add(mage2)



    // This will show nothing, as characterContainer is empty. How to handle creating abstract class objects?
    //showCharacterAtributes(characterContainer)

    // This will display Character + Player attributes
    //showPlayerAtributes(playerContainer)

    // This will display Character + Player + Profession attributes
    //showProfessionAtributes(professionContainer)

    // This will cause "Type mismatch: inferred type is Container<Character> but Container<Mage> was expected"
    //showProfessionAtributes(characterContainer)

    // This will cause "Type mismatch: inferred type is Container<Mage> but Container<Character> was expected"
    //showCharacterAtributes(professionContainer)

    fun showCharacterAtributes(container: Container<Character>) {
        container.show()
    }

    fun showPlayerAtributes(container: Container<Player>) {
        container.show()

    }

    fun showProfessionAtributes(container: Container<Mage>) {
        container.show()
    }

    class Container<T : Character> {
        val list: MutableList<T> = mutableListOf()

        fun show() {
            list.forEach{
                println(it.displayAttributes())
            }
        }
    }
}

//	 ABSTRAKCJA
abstract class Character(protected val name: String, protected var level: Int) {

    protected open var strength: Int = 1
    protected open var armor: Int = 1
    protected open var inteligence: Int = 1
    protected open var maxHp: Int = 1000
    protected open var hp: Int = maxHp


    fun takeDamage(damage: Int) {
        hp -= damage
        if (hp < 0) {
            hp = 0
            println("$name is defeated ")
        }
        else {
            println("$name reveived $damage damage.")
            println("Current health: $hp//$maxHp")
        }
    }

    //     POLIMORFIZM INKLUZYJNY, możliwość traktowania obiektów różnych klas jako obiektu ogólnego typu nadrzędnego
    fun attack(target: Character) {
        val damage = strength * 10
        println("$name attacks with $damage damage")
        target.takeDamage(damage)
    }

    open fun displayAttributes() {
        println("Name: $name \n"
                + "Level: $level \n"
                + "Strength: $strength \n"
                + "Armor: $armor \n"
                + "Inteligence: $inteligence \n"
                + "Max HP: $maxHp \n"
                + "Current HP: $hp")
    }
}



open class Player(name: String, level: Int) : Character(name, level) {
    val inventory: Inventory<Item> = Inventory()

    fun pickItem(item: Item) {
        inventory.addItem(item)
    }

    open fun levelUp() {
        level++
        println("$name reached $level level ")
        showStatistics()
    }

    fun showStatistics() {
        println("Strength: $strength \nArmor: $armor \nInteligence: $inteligence \nMax HP: $maxHp")
    }

    override fun displayAttributes() {
        super.displayAttributes()
        println("Inventory: ${inventory.count()} items")
    }
}

class Warior(name: String, level: Int) : Player(name, level) {
    override var strength = 20
    override var armor = 20
    override var inteligence = 5
    protected var stamina = 300

    //     OVERRIDING METODY
    override fun levelUp() {
        strength += 3
        armor += 2
        inteligence += 1
        maxHp += 150
        super.levelUp()
    }

    override fun displayAttributes() {
        super.displayAttributes()
        println("Stamina: $stamina")
    }
}

class Mage(name: String, level: Int) : Player(name, level), Healer {
    override var strength = 5
    override var armor = 10
    override var inteligence = 20
    protected var mana = 300
    val spellbook: MutableList<Spell> = mutableListOf()

    //     OVERRIDING METODY
    override fun levelUp() {
        strength += 1
        armor += 1
        inteligence += 3
        maxHp += 75
        hp += 75
        super.levelUp()
    }

    //     OVERLOADING METODY
    fun attack(target: Character, spell: Spell){
        println("Attack with spell")
        val damage = inteligence * spell.power
        println("$name uses magic and deals $damage damage")
        target.takeDamage(damage)
    }

    override fun displayAttributes() {
        super.displayAttributes()
        println("Mana: $mana")
    }

    override fun heal() {
        println("$name uses heal")
        hp += inteligence * 3
        if (hp > maxHp)
            hp = maxHp
        println("Current health: $hp/$maxHp")
    }
}

interface Healer {
    fun heal()
}


// Polimorfizm parametryczny (unbounded): Klasa generyczna Inventory
class Inventory<T> {
    private val items: MutableList<T> = mutableListOf()

    fun addItem(item: T) {
        items.add(item)
    }

    fun removeItem(item: T) {
        items.remove(item)
    }

    fun getItems(): List<T> {
        return items
    }

    fun count(): Int {
        return items.count()
    }

}

abstract class Item {
    open var name: String = "Item name"
}

class Sword : Item() {
    override var name = "Sword"
}

class Ring : Item() {
    override var name = "Ring"
}


// Polimorfizm ograniczeniowy (bounded): Klasa generyczna Spellbook ograniczona do klas dziedziczących od Spell
class Spellbook<T : Spell>() {
    private val spells: MutableList<T> = mutableListOf()
    fun addSpell(spell: T) {
        spells.add(spell)
    }

    fun removeSpell(spell: T) {
        spells.remove(spell)
    }

    fun getSpells(): List<T> {
        return spells
    }
}

open class Spell {
    open var power: Int = 1
}

// Klasa dziedzicząca po Spell, reprezentująca konkretny rodzaj czaru - FireBall
class FireBall : Spell() {
    override var power = 30
}

class IceBolt : Spell() {
    override var power = 25
}