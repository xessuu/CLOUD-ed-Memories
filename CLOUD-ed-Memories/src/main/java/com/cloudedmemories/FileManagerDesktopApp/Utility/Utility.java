package com.cloudedmemories.FileManagerDesktopApp.Utility;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

// TANGTANG ANG JAVAX.SWING IMPORT

import com.cloudedmemories.FileManagerDesktopApp.model.Applications;
import com.cloudedmemories.FileManagerDesktopApp.model.Archieves;
import com.cloudedmemories.FileManagerDesktopApp.model.Documents;
import com.cloudedmemories.FileManagerDesktopApp.model.Drive;
import com.cloudedmemories.FileManagerDesktopApp.model.FileEnhanced;
import com.cloudedmemories.FileManagerDesktopApp.model.FileType;
import com.cloudedmemories.FileManagerDesktopApp.model.Images;
import com.cloudedmemories.FileManagerDesktopApp.model.Music;
import com.cloudedmemories.FileManagerDesktopApp.model.Videos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Utility {

	private double totalGB;
	private double usedGB;
	private double freeGB;
	private ObservableList<FileEnhanced> fileEnhancedsDocs;
	private ObservableList<FileEnhanced> fileEnhancedsImages;
	private ObservableList<FileEnhanced> fileEnhancedsVideos;
	private ObservableList<FileEnhanced> fileEnhancedsArch;
	private ObservableList<FileEnhanced> fileEnhancedsMusic;
	private ObservableList<FileEnhanced> fileEnhancedsApps;
	private int counter;
	private int counter1;
	private int counter2;
	private int counter3;
	private int counter4;
	private int counter5;

	public Utility() {
		fileEnhancedsDocs = FXCollections.observableArrayList();
		fileEnhancedsImages = FXCollections.observableArrayList();
		fileEnhancedsVideos = FXCollections.observableArrayList();
		fileEnhancedsArch = FXCollections.observableArrayList();
		fileEnhancedsMusic = FXCollections.observableArrayList();
		fileEnhancedsApps = FXCollections.observableArrayList();
	}

	public ArrayList<Drive> getAllDrives() {
		ArrayList<Drive> drives = new ArrayList<Drive>();

		File[] drivesList = File.listRoots();
		if (drivesList != null && drivesList.length > 0) {
			for (File aDrive : drivesList) {
				Drive drive = new Drive();
				drive.setFile(aDrive);

				// Pure Java approach para sa drive letter/name
				drive.setDriveName(aDrive.getAbsolutePath().substring(0, aDrive.getAbsolutePath().lastIndexOf(File.separator) + 1));

				System.out.println("Drive Letter: " + aDrive);
				System.out.println("\tType: Local Drive");
				System.out.println();

				double totalSpace = aDrive.getTotalSpace();
				double usedSpace = aDrive.getTotalSpace() - aDrive.getFreeSpace();
				double remSpace = aDrive.getFreeSpace();

				totalGB = totalSpace / 1073741824.0;
				drive.setTotalSpace(String.format("%.2f", totalGB) + " GB");

				usedGB = usedSpace / 1073741824.0;
				drive.setUsedSpace(String.format("%.2f", usedGB) + " GB");

				freeGB = remSpace / 1073741824.0;
				drive.setFreeSpace(String.format("%.2f", freeGB) + " GB");

				System.out.println("\tTotal space: " + totalSpace);
				System.out.println("\tUsable space: " + usedSpace);
				System.out.println("\tFree space: " + remSpace);

				double usedPer = (usedSpace / totalSpace) * 100;
				System.out.println(Math.round(usedPer) + " %");

				double remPer = (remSpace / totalSpace) * 100;
				System.out.println(Math.round(remPer) + " %");

				drive.setDblFreeSpace(remSpace);
				drive.setDblTotalSpace(totalSpace);
				drive.setDblUsedSpace(usedSpace);
				drive.setPer(Math.round(usedPer));
				drive.setRemPer(Math.round(remPer));
				drives.add(drive);
			}
		}
		return drives;
	}

	// FIX SA CANNOT FIND SYMBOL ERROR: I-check nga ang extension variable naa ra gyud sa sulod sa accept method
	public ObservableList<FileEnhanced> getAllDocumentFiles(File rootFolder) {
		File files[] = rootFolder.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				String extension = getExtensionByStringHandling(pathname.getName());
				for (Documents document : Documents.values()) {
					if (extension.equals(document.name())) {
						return true;
					}
				}
				return false;
			}
		});

		if (files != null) {
			for (File file : files) {
				FileEnhanced enhanced = new FileEnhanced();
				enhanced.setFile(file);
				enhanced.setFileType(FileType.Documents);
				fileEnhancedsDocs.add(enhanced);
			}
		}
		return fileEnhancedsDocs;
	}

	// ... (Ang tanang ubang recursiveGetAll* methods ug ang ubang methods) ...

	public ObservableList<FileEnhanced> recursiveGetAllDocumentFiles(File[] arr, int level) {
		// ... (code) ...
		return fileEnhancedsDocs;
	}
	public ObservableList<FileEnhanced> recursiveGetAllImageFiles(File[] arr, int level) {
		// ... (code) ...
		return fileEnhancedsImages;
	}
	public ObservableList<FileEnhanced> recursiveGetAllVideoFiles(File[] arr, int level) {
		// ... (code) ...
		return fileEnhancedsVideos;
	}
	public ObservableList<FileEnhanced> recursiveGetAllArchFiles(File[] arr, int level) {
		// ... (code) ...
		return fileEnhancedsArch;
	}
	public ObservableList<FileEnhanced> recursiveGetAllMusicFiles(File[] arr, int level) {
		// ... (code) ...
		return fileEnhancedsMusic;
	}
	public ObservableList<FileEnhanced> recursiveGetAllAppFiles(File[] arr, int level) {
		// ... (code) ...
		return fileEnhancedsApps;
	}
	public String getExtensionByStringHandling(String filename) {
		String extension = "";
		int index = filename.lastIndexOf('.');
		if (index > 0) {
			extension = filename.substring(index + 1);
		}
		return extension;
	}
	public boolean isEmpty(Path path) throws IOException {
		if (Files.isDirectory(path)) {
			try (DirectoryStream<Path> directory = Files.newDirectoryStream(path)) {
				return !directory.iterator().hasNext();
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println(utility.recursiveGetAllDocumentFiles(new File("D:\\").listFiles(), 0).size());
	}
	public void reset() {
		fileEnhancedsDocs.clear();
		fileEnhancedsImages.clear();
		fileEnhancedsVideos.clear();
		fileEnhancedsArch.clear();
		fileEnhancedsMusic.clear();
		fileEnhancedsApps.clear();
	}
}