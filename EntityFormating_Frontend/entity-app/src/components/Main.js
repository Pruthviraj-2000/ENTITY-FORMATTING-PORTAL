import React, { useState, useEffect, useMemo } from "react";

import {
  useCSVReader,
  lightenDarkenColor,
  formatFileSize,
} from "react-papaparse";
import ReactTable from "./ReactTable";

const GREY = "#CCC";
const GREY_LIGHT = "rgba(255, 255, 255, 0.4)";
const DEFAULT_REMOVE_HOVER_COLOR = "#A01919";
const REMOVE_HOVER_COLOR_LIGHT = lightenDarkenColor(
  DEFAULT_REMOVE_HOVER_COLOR,
  40
);
const GREY_DIM = "#686868";

const styles = {
  zone: {
    alignItems: "center",
    border: `2px dashed ${GREY}`,
    borderRadius: 20,
    display: "flex",
    flexDirection: "column",
    height: "100%",
    justifyContent: "center",
    padding: 20,
  },
  file: {
    background: "linear-gradient(to bottom, #EEE, #DDD)",
    borderRadius: 20,
    display: "flex",
    height: 120,
    width: 120,
    position: "relative",
    zIndex: 10,
    flexDirection: "column",
    justifyContent: "center",
  },
  info: {
    alignItems: "center",
    display: "flex",
    flexDirection: "column",
    paddingLeft: 10,
    paddingRight: 10,
  },
  size: {
    backgroundColor: GREY_LIGHT,
    borderRadius: 3,
    marginBottom: "0.5em",
    justifyContent: "center",
    display: "flex",
  },
  name: {
    backgroundColor: GREY_LIGHT,
    borderRadius: 3,
    fontSize: 12,
    marginBottom: "0.5em",
  },
  progressBar: {
    bottom: 14,
    position: "absolute",
    width: "100%",
    paddingLeft: 10,
    paddingRight: 10,
  },
  zoneHover: {
    borderColor: GREY_DIM,
  },
  default: {
    borderColor: GREY,
  },
  remove: {
    height: 23,
    position: "absolute",
    right: 6,
    top: 6,
    width: 23,
  },
};
const Main = ({ updatedRows, handleColumns }) => {
  const { CSVReader } = useCSVReader();
  const [csvData, setCsvData] = useState({});
  const [columnData, setColumnData] = useState([]);
  const [rowData, setRowData] = useState([]);
  const [zoneHover, setZoneHover] = useState(false);
  const [removeHoverColor, setRemoveHoverColor] = useState(
    DEFAULT_REMOVE_HOVER_COLOR
  );

  const columns = useMemo(() => columnData, [columnData]);

  const rows = useMemo(() => rowData, [rowData]);

  useEffect(() => {
    if (updatedRows.length > 0) {
      console.log(updatedRows);
      setRowData(updatedRows);
    }
  }, [updatedRows]);

  useEffect(() => {
    if (Object.keys(csvData).length > 0) {
      const columns = csvData?.data[0]?.map((col, index) => {
        return {
          Header: col.trim(),
          accessor: col.trim().split(" ").join().toLowerCase(),
        };
      });

      const rows = csvData.data.slice(1).map((row) => {
        return row.reduce((acc, curr, index) => {
          acc[columns[index].accessor] = curr;
          return acc;
        }, {});
      });

      handleColumns({ columns: columns, rows: rows });

      setColumnData(columns);
      setRowData(rows);
    }
  },[csvData]);

  const handleFileUpload = (results) => {
    setZoneHover(false);
    setCsvData(results);
  };

  return (
    <div className="ms-2">
    <CSVReader
      onUploadAccepted={handleFileUpload}
      onDragOver={(event) => {
        event.preventDefault();
        setZoneHover(true);
      }}
      onDragLeave={(event) => {
        event.preventDefault();
        setZoneHover(false);
      }}
      remove={() => alert(1)}
    >
      {({
        getRootProps,
        acceptedFile,
        ProgressBar,
        getRemoveFileProps,
        Remove,
      }) => (
        <>
          <div
            {...getRootProps()}
            style={Object.assign(
              {},
              styles.zone,
              zoneHover && styles.zoneHover
            )}
          >
            {acceptedFile ? (
              <>
                <div style={styles.file}>
                  <div style={styles.info}>
                    <span style={styles.size}>
                      {formatFileSize(acceptedFile.size)}
                    </span>
                    <span style={styles.name}>{acceptedFile.name}</span>
                  </div>
                  <div style={styles.progressBar}>
                    <ProgressBar/>
                  </div>
                  <div
                    {...getRemoveFileProps()}
                    style={styles.remove}
                    onMouseOver={(event) => {
                      event.preventDefault();
                      setRemoveHoverColor(REMOVE_HOVER_COLOR_LIGHT);
                    }}
                    onMouseOut={(event) => {
                      event.preventDefault();
                      setRemoveHoverColor(DEFAULT_REMOVE_HOVER_COLOR);
                    }}
                  >
                    <Remove color={removeHoverColor} />
                  </div>
                </div>
              </>
            ) : (
              "Click to upload"
            )}
          </div>
          <ReactTable
            rowData={rows}
            columnData={columns}
          />
        </>
      )}
    </CSVReader>
    </div>
  );
};

export default Main;
