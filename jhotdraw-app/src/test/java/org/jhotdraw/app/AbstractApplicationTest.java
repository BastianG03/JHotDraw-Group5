package org.jhotdraw.app;

import static org.junit.Assert.*;

import java.awt.Component;
import java.net.URI;
import java.util.List;

import javax.swing.ActionMap;
import javax.swing.JMenu;

import org.jhotdraw.api.app.Application;
import org.jhotdraw.api.app.ApplicationModel;
import org.jhotdraw.api.app.Disposable;
import org.jhotdraw.api.app.View;
import org.jhotdraw.api.gui.URIChooser;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for AbstractApplication.openNewView().
 */
public class AbstractApplicationTest {

    private TestApplication app;

    @Before
    public void setUp() {
        app = new TestApplication();
        app.setModel(new FakeApplicationModel());
    }

    @Test
    public void testOpenNewViewMultipleTimesCreatesMultipleViews() {
        View v1 = app.openNewView();
        View v2 = app.openNewView();
        View v3 = app.openNewView();

        assertEquals(
                "Opening multiple views should increase view count",
                3,
                app.getViews().size());
    }

    @Test
    public void testLastOpenedViewIsActiveViewWhenMultipleViewsExist() {
        View v1 = app.openNewView();
        View v2 = app.openNewView();

        assertEquals(
                "The last opened view should be the active view",
                v2,
                app.getActiveView());
    }

    @Test
    public void testOpenNewViewCreatesView() {
        View view = app.openNewView();
        assertNotNull("openNewView should create a new view", view);
    }

    @Test
    public void testOpenViewAddsView() {
        app.openNewView();
        assertEquals(
                "There should be one view after opening a new view",
                1,
                app.getViews().size());
    }

    @Test
    public void testOpenNewViewSetsActiveView() {
        View view = app.openNewView();
        assertEquals(
                "The opened view should be the active view",
                view,
                app.getActiveView());
    }
}

/*
 * -------------------------------------------------
 * Test doubles (fakes)
 * -------------------------------------------------
 */

class TestApplication extends AbstractApplication {

    // 🔑 REQUIRED: expose protected setModel for tests
    @Override
    public void setModel(ApplicationModel model) {
        super.setModel(model);
    }

    @Override
    protected ActionMap createViewActionMap(View v) {
        return new ActionMap();
    }

    @Override
    protected View basicCreateView() {
        return getModel().createView();
    }

    // ---------- Required by Application interface ----------

    @Override
    public boolean isSharingToolsAmongViews() {
        return false;
    }

    @Override
    public Component getComponent() {
        return null; // no UI in unit tests
    }

    @Override
    public JMenu createFileMenu(View v) {
        return null;
    }

    @Override
    public JMenu createEditMenu(View v) {
        return null;
    }

    @Override
    public JMenu createViewMenu(View v) {
        return null;
    }

    @Override
    public JMenu createWindowMenu(View v) {
        return null;
    }

    @Override
    public JMenu createHelpMenu(View v) {
        return null;
    }

    // ---------- UI lifecycle (stubbed) ----------

    @Override
    public void show(View v) {
        // intentionally empty
    }

    @Override
    public void hide(View v) {
        // intentionally empty
    }
}

class FakeApplicationModel implements ApplicationModel {

    @Override
    public View createView() {
        return new FakeView();
    }

    @Override
    public void initView(Application a, View v) {
        // intentionally empty (stub)
    }

    @Override
    public void destroyView(Application a, View v) {
        // intentionally empty (stub)
    }

    /* --- Unused methods for this test --- */

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getVersion() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getCopyright() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void initApplication(Application a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void destroyApplication(Application a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ActionMap createActionMap(Application a, View v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<javax.swing.JToolBar> createToolBars(Application a, View v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public org.jhotdraw.api.app.MenuBuilder getMenuBuilder() {
        throw new UnsupportedOperationException();
    }

    @Override
    public URIChooser createOpenChooser(Application a, View v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public URIChooser createOpenDirectoryChooser(Application a, View v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public URIChooser createSaveChooser(Application a, View v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public URIChooser createImportChooser(Application a, View v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public URIChooser createExportChooser(Application a, View v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isOpenLastURIOnLaunch() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isAllowMultipleViewsPerURI() {
        throw new UnsupportedOperationException();
    }
}

class FakeView extends AbstractView {
    // Minimal fake view for testing. AbstractView already implements most
    // behavior (including getComponent returning a JComponent), so we only
    // provide small stubs if needed.

    @Override
    public void init() {
        // no-op
    }

    @Override
    public void dispose() {
        // no-op
    }

    @Override
    public void activate() {
        // no-op
    }

    @Override
    public void deactivate() {
        // no-op
    }

    @Override
    public void clear() {
        // no-op
    }

    @Override
    public void read(URI uri, URIChooser chooser) {
        // no-op for tests
    }

    @Override
    public void write(URI uri, URIChooser chooser) {
        // no-op for tests
    }

}
