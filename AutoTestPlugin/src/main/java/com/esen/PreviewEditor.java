//package com.esen;
//
//
//import com.intellij.openapi.editor.Document;
//import com.intellij.openapi.fileEditor.*;
//import com.intellij.openapi.project.PossiblyDumbAware;
//import com.intellij.openapi.project.Project;
//import com.intellij.openapi.vfs.VirtualFile;
//import com.vladsch.idea.multimarkdown.MultiMarkdownLanguage;
//import com.vladsch.idea.multimarkdown.settings.FailedBuildRunnable;
//import com.vladsch.idea.multimarkdown.settings.MultiMarkdownGlobalSettings;
//import javafx.application.Platform;
//import org.jdom.Element;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//import java.lang.reflect.Constructor;
//
//public class PreviewEditor implements FileEditorProvider, PossiblyDumbAware {
////    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MultiMarkdownFxPreviewEditorProvider.class);
//
//    private static final int FX_PREVIEW_UNKNOWN = 0;
//    private static final int FX_PREVIEW_HAVE_JAR = 1;
//    private static final int FX_PREVIEW_CAN_LOAD = 2;
//    private static final int FX_PREVIEW_CANNOT_LOAD = 3;
//
//    //    public static final String EDITOR_TYPE_ID = MultiMarkdownLanguage.NAME + "FxPreviewEditor";
//    private static int canLoadFxEditor = FX_PREVIEW_UNKNOWN;
//    private static Class<?> MultiMarkdownFxPreviewEditor;
//    private static Constructor<?> classConstructor;
//
//    public static boolean accept(@NotNull VirtualFile file) {
//        return PreviewEditor.accept(file);
//    }
//
//    public boolean accept(@NotNull Project project, @NotNull VirtualFile file) {
//        return accept(file);
//    }
//
//    @NotNull
//    @Override
//    public FileEditor createEditor(@NotNull Project project, @NotNull VirtualFile file) {
//        return createEditor(project, file, false);
//    }
//
//    @NotNull
//    public static FileEditor createEditor(@NotNull final Project project, @NotNull final VirtualFile file, final boolean forRawHtml) {
//        final Document document = FileDocumentManager.getInstance().getDocument(file);
//        assert document != null;
//
//        if (!MultiMarkdownGlobalSettings.getInstance().useOldPreview.getValue()) {
//            return MultiMarkdownGlobalSettings.getInstance().fxPreviewFailedBuild.runBuild(new FailedBuildRunnable<FileEditor>() {
//                @Nullable
//                @Override
//                public FileEditor runCanFail() throws Throwable {
//                    MultiMarkdownGlobalSettings.getInstance().setIsFxHtmlPreview(true);
//                    boolean isFxApplicationThread = Platform.isFxApplicationThread();
//                    return new MultiMarkdownFxPreviewEditor(project, document, forRawHtml);
//                }
//
//                @Nullable
//                @Override
//                public FileEditor run() {
//                    MultiMarkdownGlobalSettings.getInstance().setIsFxHtmlPreview(false);
//                    MultiMarkdownGlobalSettings.getInstance().useOldPreview.setValue(true);
//                    return new MultiMarkdownPreviewEditor(project, document, forRawHtml);
//                }
//            });
//        }
//        return new MultiMarkdownPreviewEditor(project, document, forRawHtml);
//    }
//
//    public void disposeEditor(@NotNull FileEditor editor) {
//        editor.dispose();
//    }
//
//    @NotNull
//    @Override
//    public FileEditorState readState(@NotNull Element sourceElement, @NotNull Project project, @NotNull VirtualFile file) {
//        return FileEditorState.INSTANCE;
//    }
//
//    @Override
//    public void writeState(@NotNull FileEditorState state, @NotNull Project project, @NotNull Element targetElement) {
//    }
//
//    @NotNull
//    @Override
//    public String getEditorTypeId() {
//        return EDITOR_TYPE_ID;
//    }
//
//    @NotNull
//    @Override
//    public FileEditorPolicy getPolicy() {
//        return FileEditorPolicy.PLACE_AFTER_DEFAULT_EDITOR;
//    }
//
//    @Override
//    public boolean isDumbAware() {
//        return true;
//    }
//}
