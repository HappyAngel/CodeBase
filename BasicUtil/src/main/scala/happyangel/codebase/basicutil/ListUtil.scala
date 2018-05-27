package happyangel.codebase.basicutil

object ListUtil {

  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    for {
      aa <- a
      bb <- b
    } yield {
      f(aa,bb)
    }
  }

  // traverse a list and try to transform to option, if any returns None, all is None
  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = {
    a match {
      case Nil => Some(Nil)
      case h::t => f(h) flatMap (hh => traverse(t)(f) map(hh::_))
    }
  }

  def sequenceRur[A](a: List[Option[A]]): Option[List[A]] = {
    a match {
      case Nil =>
        Some(Nil)
      case h::t => h flatMap (hh => sequenceRur(t) map (hh::_))
    }
  }

  def sequenceViaFold[A](a: List[Option[A]]): Option[List[A]] = {
    a.foldRight[Option[List[A]]](Some(Nil))((a, b) => map2(a,b)(_::_))
  }

}