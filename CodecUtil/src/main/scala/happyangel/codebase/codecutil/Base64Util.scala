package main.scala.happyangel.codebase.codecutil

import java.security.MessageDigest
import java.util.Base64

import happyangel.codebase.codecutil.Algorithm


object Base64Util {
    def getBase64Encode(s: String) (implicit algorithm: String = Algorithm.MD5): String = {
        algorithm match {
            case Algorithm.MD5 =>
                Base64.getEncoder.encodeToString(MessageDigest.getInstance("MD5").digest(s.getBytes))
            case _ => throw new IllegalArgumentException("bad algorithm: " + algorithm)
        }
    }
}