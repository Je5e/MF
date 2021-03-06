package com.kodigo.managmentflights.helpers;

import com.kodigo.managmentflights.Entities.Flight;
import com.kodigo.managmentflights.Entities.FlightSchedule;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class DocumentGeneratorImp implements IDocumentGenerator {
    @Override
    public boolean writeToExcelFile(List<Flight> flightList, String filePath, String weather) {
        boolean result;
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        createRowHeader(sheet);
        int rowCount = 0;
        for (Flight f : flightList) {
            Row row = sheet.createRow(++rowCount);
            writeFlight(f, row);
            for (FlightSchedule fs : f.getSchedules()) {
                writeFlightsSchedule(fs, row, weather);
            }
        }
        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            workbook.write(fileOutputStream);
            result=true;
        } catch (IOException e) {
            e.printStackTrace();
            result =false;
        }
        return result;
    }

    private void createRowHeader(Sheet sheet) {
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        cellStyle.setFont(font);

        Row row = sheet.createRow(0);
        Cell cellFlightNumber= row.createCell(1);
        cellFlightNumber.setCellStyle(cellStyle);
        cellFlightNumber.setCellValue("Flight Number");

        Cell cellPaisOrigen = row.createCell(2);
        cellPaisOrigen.setCellStyle(cellStyle);
        cellPaisOrigen.setCellValue("Pais origen");
        Cell cellPaisDestino =row.createCell(3);
        cellPaisDestino.setCellStyle(cellStyle);
        cellPaisDestino.setCellValue("Pais Destino");
        Cell fechaHoraSalida = row.createCell(4);
        fechaHoraSalida.setCellStyle(cellStyle);
        fechaHoraSalida.setCellValue("Fecha/hora salida");
        Cell fechaHoraLlegada = row.createCell(5);
        fechaHoraLlegada.setCellStyle(cellStyle);
        fechaHoraLlegada.setCellValue("Fecha/hora llegada");
        Cell status = row.createCell(6);
        status.setCellStyle(cellStyle);
        status.setCellValue("Status");
        Cell motivo = row.createCell(7);
        motivo.setCellStyle(cellStyle);
        motivo.setCellValue("Comment");
        Cell weather = row.createCell(8);
        weather.setCellStyle(cellStyle);
        weather.setCellValue("Weather");
    }

    private void writeFlightsSchedule(FlightSchedule fs, Row row,String w) {
        Cell cell = row.createCell(4);

        cell.setCellValue(fs.getDateDaparture().toString());

        cell = row.createCell(5);
        cell.setCellValue(fs.getDateArrival().toString());

        cell = row.createCell(6);
        cell.setCellValue(fs.getStatus().toString());
        cell = row.createCell(7);
        cell.setCellValue(fs.getComment());

        cell = row.createCell(8);
        cell.setCellValue(w);
    }

    private void writeFlight(Flight f, Row row) {
        Cell cell = row.createCell(1);
        cell.setCellValue(f.getFlightNumber());

        cell = row.createCell(2);
        cell.setCellValue(f.getDeparture().getCountry());

        cell = row.createCell(3);
        cell.setCellValue(f.getArrival().getCountry());

    }
}

