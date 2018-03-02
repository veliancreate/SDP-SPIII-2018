package sml

import sml.instructions.NoOpInstruction

/**
 * Constructor: an instruction with label l and opcode op
 * (op must be an operation of the language)
 *  = the representation "label: opcode" of this sml.Instruction
 */
abstract class Instruction(protected var label: String, protected var opcode: String) {

    companion object {
        fun getNextInstruction(ins: MutableList<Instruction>, labelToFind: String): Instruction {
            val nextIns = ins.find {  it.label == labelToFind }
            return when (nextIns) {
                is Instruction -> nextIns
                else -> throw Error("Instruction ${labelToFind} does not exist - exiting")
            }
        }
    }

    override fun toString(): String {
        return label + ": " + opcode
    }

    /**
     * Execute this instruction on machine m.
     */
    abstract fun execute(m: Machine)
}
