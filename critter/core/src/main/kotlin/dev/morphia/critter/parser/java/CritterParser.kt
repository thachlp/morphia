package dev.morphia.critter.parser.java

import dev.morphia.annotations.Property
import dev.morphia.mapping.codec.pojo.PropertyModel
import java.io.File
import java.io.PrintWriter
import java.io.StringWriter
import org.objectweb.asm.ClassReader
import org.objectweb.asm.Type
import org.objectweb.asm.util.ASMifier
import org.objectweb.asm.util.TraceClassVisitor

object CritterParser {
    var outputGenerated: File? = null
    val critterClassLoader = CritterClassLoader(PropertyModel::class.java.classLoader)
    val propertyAnnotations = mutableListOf(Type.getType(Property::class.java))
    val transientAnnotations = mutableListOf(Type.getType(Transient::class.java))

    fun asmify(bytes: ByteArray): String {
        val classReader = ClassReader(bytes)
        val traceWriter = StringWriter()
        val printWriter = PrintWriter(traceWriter)
        val traceClassVisitor = TraceClassVisitor(null, ASMifier(), printWriter)
        classReader.accept(traceClassVisitor, 0)
        return traceWriter.toString()
    }

    fun propertyAnnotations(): List<String> {
        return propertyAnnotations.map { it.descriptor }
    }

    fun transientAnnotations(): List<String> {
        return transientAnnotations.map { it.descriptor }
    }
}
