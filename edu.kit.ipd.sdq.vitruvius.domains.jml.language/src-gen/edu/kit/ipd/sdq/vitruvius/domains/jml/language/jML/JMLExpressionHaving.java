/**
 */
package edu.kit.ipd.sdq.vitruvius.domains.jml.language.jML;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Having</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.domains.jml.language.jML.JMLExpressionHaving#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.vitruvius.domains.jml.language.jML.JMLPackage#getJMLExpressionHaving()
 * @model
 * @generated
 */
public interface JMLExpressionHaving extends EObject
{
  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expression)
   * @see edu.kit.ipd.sdq.vitruvius.domains.jml.language.jML.JMLPackage#getJMLExpressionHaving_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link edu.kit.ipd.sdq.vitruvius.domains.jml.language.jML.JMLExpressionHaving#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

} // JMLExpressionHaving