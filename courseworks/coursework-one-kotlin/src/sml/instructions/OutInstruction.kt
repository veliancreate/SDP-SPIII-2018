package sml.instructions

import sml.Instruction
import sml.Machine

class OutInstruction(label: String, val register: Int): Instruction(label, "out") {
    override fun execute(m: Machine) {
        println("\n --- value of register " + register + " is " + m.registers.getRegister(register))
    }

    override fun toString(): String {
        return super.toString() + " " + register
    }
}