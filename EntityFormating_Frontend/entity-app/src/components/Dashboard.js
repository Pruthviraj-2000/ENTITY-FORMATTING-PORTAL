import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import dayjs from 'dayjs';
import Main from "./Main";
import 'bootstrap/dist/css/bootstrap.min.css';
import { format } from "./Util/Formatt";
import * as xlsx from 'xlsx';
import axios from "axios";

const Dashboard = ({isAuthenticated}) => {
  
  const navigate = useNavigate();
  const [rows, setRows] = useState([]);
  const [updatedRow, setUpdatedRow] = useState([]);
  const [columns, setColumns] = useState([]);
  const [selectedColumn, setSelectedColumn] = useState("");
  const [selectedFormat, setSelectedFormat] = useState("");

  useEffect(()=>{
    if(!isAuthenticated){
      navigate("/")
    }
  })
  const handleColumns = ({ columns, rows }) => {
    setColumns(columns);
    setRows(rows);
  };
  const handleSignOut=(e)=>{
    e.preventDefault();
    navigate('/')
  }
  const handlDownload=(e)=>{
    e.preventDefault();
    console.log(rows);
    var wb = xlsx.utils.book_new(),
      ws = xlsx.utils.json_to_sheet(rows);
    xlsx.utils.book_append_sheet(wb, ws, "MySheet");
    xlsx.writeFile(wb, "FormattedCSV.xlsx");
    axios.post("http://localhost:8080/api/file/uploadjson", rows, {
      headers: {
        Authorization: `Bearer ${sessionStorage.getItem("token")}`,
      },
    });
    
  }

  const handleFormat = (e) => {
    setSelectedFormat(e.target.value);

    let result = [];

    if (selectedColumn === "date") {
      if(e.target.value === "mm-dd-yyyy"){
        result = rows.filter((item)=>{
          const updatedDate = dayjs(item[selectedColumn]);
          console.log(updatedDate)
          item[selectedColumn] = updatedDate.format("MM DD YYYY");
          return item;
        })
      }else if(e.target.value === "yyyy-mm-dd"){
        result = rows.filter((item)=>{
          const updatedDate = dayjs(item[selectedColumn]);
          console.log(updatedDate)
          item[selectedColumn] = updatedDate.format("YYYY MM DD");
          return item;
        })
      }
    }else if(selectedColumn === "name") {
      if(e.target.value === "Uppercase"){
        result = rows.filter((item)=>{
          const updatedName = item[selectedColumn].toUpperCase();
          item[selectedColumn] = updatedName;
          console.log(updatedName)
          return item;
       })
      }else if(e.target.value === "Lowercase"){
        result = rows.filter((item)=>{
          const updatedName = item[selectedColumn].toLowerCase();
          item[selectedColumn] = updatedName;
          console.log(updatedName)
          return item;
        })
    }
    }else if(selectedColumn === "price"){
      if(e.target.value === "INR"){
      result = rows.filter((item)=>{
        const updatedPrice = new 
        Intl.NumberFormat("en-US",{
          style:"currency",
          currency:"inr",
          minimumFractionDigits:0,
          maximumFractionDigits:0,
        }).format(item[selectedColumn]);
        item[selectedColumn] = updatedPrice;
        console.log(updatedPrice)
        return item;
      })
    }else if(e.target.value === "GBP"){
      result = rows.filter((item)=>{
        const updatedPrice = new 
        Intl.NumberFormat("en-US",{
          style:"currency",
          currency:"gbp",
          minimumFractionDigits:0,
          maximumFractionDigits:0,
        }).format(item[selectedColumn]);
        item[selectedColumn] = updatedPrice;
        console.log(updatedPrice)
        return item;
      })
    }
    }else if(selectedColumn === "tax"){
      if(e.target.value === "Percentage"){
        result = rows.filter((item)=>{
          const updatedTax = 
          parseFloat(item[selectedColumn]);
          console.log(updatedTax)
          item[selectedColumn] = updatedTax.toLocaleString("en-US",{
            style:"percent",
          });
          console.log(updatedTax)
          return item;
        })
      }
    }else if(selectedColumn === "description") {
      if(e.target.value === "Uppercase Description"){
        result = rows.filter((item)=>{
          const updatedDes = item[selectedColumn].toUpperCase();
          item[selectedColumn] = updatedDes;
          console.log(updatedDes)
          return item;
       })
      }else if(e.target.value === "Lowercase Description"){
        result = rows.filter((item)=>{
          const updatedDes = item[selectedColumn].toLowerCase();
          item[selectedColumn] = updatedDes;
          console.log(updatedDes)
          return item;
        })
    }
    }
    setUpdatedRow(result);
  } 
  return (
    <div style={{ marginTop: "50px" }}>
      <div className="row">
        <div className="col-lg-6">
          <div style={{ margin: "1rem" }}>
            <h6
              style={{ margin: "1rem 0" }}
            >
              Actions
            </h6>
            <div>
            <button className="btn btn-success" onClick={handlDownload}>Download</button>
            </div>
            <form>
              <label id='demo-simple-select-label'>
                Select Column
                </label>
              <select id="demo-select" className="form-select" value={selectedColumn} label="Select Column"
              onChange={(e)=> setSelectedColumn(e.target.value)}>
                {columns.map((column) => (
                  <option value={column.accessor}>{column.Header}</option>
                ))}
              </select>
            </form>
          </div>
          <div style={{ margin: "1rem" }}>
            <form>
              <label id='demo-simple-select-label'>
                Format Options
              </label>
              <select
                labelId='demo-simple-select-label'
                className="form-select"
                id='demo-simple-select'
                value={selectedFormat}
                label='Format Options'
                onChange={handleFormat}
              >
                {format[selectedColumn]?.map((val) => (
                  <option value={val}>{val}</option>
                ))}
              </select>
            </form>
          </div>
        </div>
        <div style={{ margin: "1rem" }}>
        <button className="btn btn-danger"onClick={handleSignOut}>SignOut</button>
        </div>
        <div className="row">
          <Main
            handleColumns={handleColumns}
            updatedRows={updatedRow}
          />
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
