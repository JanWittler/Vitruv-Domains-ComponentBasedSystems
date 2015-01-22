package edu.kit.ipd.sdq.vitruvius.framework.model.monitor.classification.postchange;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IPackageFragment;

import edu.kit.ipd.sdq.vitruvius.framework.model.monitor.PreviousASTState;
import edu.kit.ipd.sdq.vitruvius.framework.model.monitor.events.ChangeClassifyingEvent;
import edu.kit.ipd.sdq.vitruvius.framework.model.monitor.events.RenamePackageEvent;

public class RenamePackageClassifier extends PackageClassifier {

    @Override
    protected List<? extends ChangeClassifyingEvent> classifyPackageChange(IJavaElementDelta delta,
            PreviousASTState previousState) {
        IJavaElement element = delta.getElement();
        if (element.getElementType() == IJavaElement.PACKAGE_FRAGMENT && delta.getKind() == IJavaElementDelta.REMOVED
                && (delta.getFlags() & IJavaElementDelta.F_MOVED_TO) != 0) {
            final IPackageFragment pkg = (IPackageFragment) element;
            final IPackageFragment renamedPkg = (IPackageFragment) delta.getMovedToElement();
            if (pkg != null && renamedPkg != null) {
                return new ArrayList<RenamePackageEvent>() {
                    private static final long serialVersionUID = 1L;

                    {
                        add(new RenamePackageEvent(pkg.getElementName(), renamedPkg.getElementName(),
                                pkg.getResource(), renamedPkg.getResource()));
                    }
                };
            }
        }
        return EMPTY_LIST;
    }
}